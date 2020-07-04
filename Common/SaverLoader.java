package Common;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaverLoader
{
    public static class Saver
    {
        public void Save(String fileName, Object objectToSerialize)
        {
            try
            {
                FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(objectToSerialize);
                objectOutputStream.close();
            }
            catch (Exception e)
            {
                
            }
        }
    }
}
