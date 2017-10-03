package us.ihmc.rosidl;

import java.util.List;
import java.util.Collections;
import org.python.core.Py;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PyList;
import org.python.util.PythonInterpreter;


public class GenerateDDSIDL
{
        private final PythonInterpreter interp = new PythonInterpreter();
        
        public GenerateDDSIDL()
        {
            interp.exec("from rosidl_generator_dds_idl import generate_dds_idl");
        }
        
        public void generate_dds_idl(String argFile, List<String> subFolders, List<String> extensions)
        {
            interp.set("argFile", new PyString(argFile));
            
            PyList subFolderList = new PyList();
            for(String subFolder : subFolders)
                subFolderList.add(new PyString(subFolder));
            
            interp.set("subFolders", subFolderList);
            
            if(extensions != null && extensions.size() > 0)
            {
                PyList extensionList = new PyList();
                for(String extension : extensions)
                    extensionList.add(new PyString(extension));
            
                interp.set("extension", extensionList);
            }
            else
                interp.set("extension", Py.None);
        
            interp.exec("generate_dds_idl(argFile, subFolders, extension)");
        }
        
        
        public static void main(String[] args)
        {
            if(args.length != 3 && args.length != 2)
            {
                System.out.println("Usage: GenerateDDSIDL [argFile] [subFolders] [extension]");
                System.exit(-1);
            }
            
            GenerateDDSIDL gen = new GenerateDDSIDL();
            if(args.length == 2)
            {
                gen.generate_dds_idl(args[0], Collections.singletonList(args[1]), null);
            }
            else
            {
                gen.generate_dds_idl(args[0], Collections.singletonList(args[1]), Collections.singletonList(args[2]));
            }
            
            
        }
}
