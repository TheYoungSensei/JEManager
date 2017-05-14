package ihm;

import static util.Util.checkString;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import ucc.UserUcc;

/*
 * This class is a more simple a to implement the plugin pattern. It's directly inspired of the
 * example of Mr Leleux's coo class.
 */

public class PluginProperties {

  private final Properties prop = new Properties();
  private final Map<String, Object> classesDependency = new HashMap<>();

  /**
   * This initialize the Properties.
   * 
   * @param fileName The name of the properties's file we want to use
   */
  public PluginProperties(String fileName) {
    checkString(fileName);
    try (FileInputStream input = new FileInputStream(fileName)) {
      prop.load(input);
    } catch (FileNotFoundException fnfe) {
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  /**
   * Assure the plugin factory pattern.
   * 
   * @param classInterface Interface of which the instance is requested
   * @return this
   */
  // Flyweight Pattern
  public Object getPluginFor(final Class<?> classInterface) {
    // If test for Appconfig instance request
    if (classInterface.getName().equalsIgnoreCase(this.getClass().getName())) {
      return this;
    }


    try {
      // If test for already existing instance
      if (classesDependency.containsKey(classInterface.getName())) {
        return classesDependency.get(classInterface.getName());
      }
      String toCreate = prop.getProperty(classInterface.getName());
      Set<Entry<String, Object>> existingDepency = classesDependency.entrySet();
      // Test : if interface share the same implementation instance object with an other interface.
      for (Entry<String, Object> key : existingDepency) {
        Object sameInstanceObjectTest = key.getValue();
        if (sameInstanceObjectTest.getClass().getName().equalsIgnoreCase(toCreate)) {
          classesDependency.put(classInterface.getName(), sameInstanceObjectTest);
          return sameInstanceObjectTest;
        }
      }
      Class<?> foundClass = Class.forName(toCreate);
      Constructor<?> constructor = foundClass.getDeclaredConstructors()[0];
      constructor.setAccessible(true);
      Class<?>[] constructorParamterTypes = constructor.getParameterTypes();
      Object[] param = null;
      if (constructor.getParameterCount() != 0) {
        param = new Object[constructorParamterTypes.length];
        for (int i = 0; i < constructorParamterTypes.length; i++) {
          Class<?> toInsert = constructorParamterTypes[i];
          param[i] = this.getPluginFor(toInsert);
        }
      }
      Object toReturn = constructor.newInstance(param);
      classesDependency.put(classInterface.getName(), toReturn);
      return toReturn;
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | IllegalArgumentException | InvocationTargetException exception) {
      exception.printStackTrace();
    }
    return null;
  }

  /**
   * Retrieve the corresponding query form the properties file.
   * 
   * @param query the query needed
   * @return the corresponding query form the properties file
   */
  public String getProperty(String query) {
    return prop.getProperty(query);
  }


  /**
   * For Testing : tips for uncomment the main function -> select the function and push ctrl + shift
   * + c.
   * 
   * @param args The name of the class we want to handle
   */
  public static void main(String[] args) {

    System.out.println(args[0]);
    PluginProperties props = new PluginProperties(args[0]);
    System.out.println(UserUcc.class.getName());

    UserUcc ucc = (UserUcc) props.getPluginFor(UserUcc.class);
    UserUcc test = (UserUcc) props.getPluginFor(UserUcc.class);
    if (ucc == test) {
      System.out.println("ucc : " + ucc);
      System.out.println("test : " + test);
      System.out.println("ok");
    }
    System.out.println(props.getPluginFor(UserUcc.class).getClass().getName());


  }

}
