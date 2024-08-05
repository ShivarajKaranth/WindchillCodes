package ext.newspace.test;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import wt.fc.WTObject;
import wt.folder.Folder;
import wt.inf.container.WTContainer;
import wt.inf.container.WTContainerRef;
import wt.method.RemoteMethodServer;
import wt.part.WTPart;
import wt.pom.PersistenceException;
import wt.session.SessionHelper;
import wt.content.ApplicationData;
import wt.util.WTException;
import wt.util.WTInvalidParameterException;
import wt.util.WTPropertyVetoException;
import wt.vc.wip.WorkInProgressException;
import wt.content.ContentHelper;
import wt.content.ContentHolder;
import wt.content.ContentRoleType;
import wt.content.ContentServerHelper;
import wt.content.FormatContentHolder;
import wt.doc.WTDocument;
import wt.epm.EPMDocument;

public class _TestEntryPointnewtest implements wt.method.RemoteAccess, Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		String user = args[0];
		String pwd = args[1];
		
		try {
			System.out.println("--main method begins--");
            RemoteMethodServer rms = wt.method.RemoteMethodServer.getDefault();
            rms.setUserName(user);
            rms.setPassword(pwd);       
            Class<?>[] argTypes = {String.class}; 
            String strArgs = args[2];
            String strOption = args[3];
            Object[] args1 = {strArgs};
            SessionHelper.manager.setAuthenticatedPrincipal(user);
            if(strOption.equals("1")){
            rms.invoke("replaceAttachment", ext.newspace.test._TestEntryPointnewtest.class.getName(), new ext.newspace.test._TestEntryPointnewtest(), argTypes, args1);
            }
            else if(strOption.equals("2")){
            	rms.invoke("createDoc", ext.newspace.test._TestEntryPointnewtest.class.getName(), new ext.newspace.test._TestEntryPointnewtest(), argTypes, args1);	
            }
            else if(strOption.equals("3")){
            	rms.invoke("prepareToCreateEPMDoc", ext.newspace.test._TestEntryPointnewtest.class.getName(), new ext.newspace.test._TestEntryPointnewtest(), argTypes, args1);	
            }
            //else if(strOption.equals("4")){
            	//rms.invoke("linkcreation", ext.newspace.test._TestEntryPointnewtest.class.getName(), new ext.newspace.test._TestEntryPointnewtest(), argTypes, args1);	
            //}
            else if(strOption.equals("5")){
            	rms.invoke("reflinkcreation", ext.newspace.test._TestEntryPointnewtest.class.getName(), new ext.newspace.test._TestEntryPointnewtest(), argTypes, args1);	
            }
            else if(strOption.equals("6")){
            	rms.invoke("epmreflinkcreation", ext.newspace.test._TestEntryPointnewtest.class.getName(), new ext.newspace.test._TestEntryPointnewtest(), argTypes, args1);	
            }
            else if(strOption.equals("7")){
            	rms.invoke("wtreflinkdeletion", ext.newspace.test._TestEntryPointnewtest.class.getName(), new ext.newspace.test._TestEntryPointnewtest(), argTypes, args1);	
            }
             else if(strOption.equals("8")){
            	rms.invoke("epmlinkdeletion", ext.newspace.test._TestEntryPointnewtest.class.getName(), new ext.newspace.test._TestEntryPointnewtest(), argTypes, args1);	
            }
            
            }catch (InvocationTargetException ite) {
	        	System.out.println("Exception occured during execution.");
	            ite.printStackTrace();

	        }catch (Exception re) {
	        	System.out.println("Unable to invoke method server");
	            re.printStackTrace();
	        }	
		
		}
	
	public static void replaceAttachment(String string) throws IOException
	{
		_TestServiceImplnewtest _service = new ext.newspace.test._TestServiceImplnewtest();
		boolean _flag = _service.replaceAttachment(string);
	}
	public static void createDoc(String string) throws WTException
	{
		_TestServiceImplnewtest _service = new ext.newspace.test._TestServiceImplnewtest();
		boolean _flag = _service.createDoc(string);
	}
	public static void prepareToCreateEPMDoc(String string) throws WTException, WTInvalidParameterException, WTPropertyVetoException 
	{
		_TestServiceImplnewtest _service = new ext.newspace.test._TestServiceImplnewtest();
		boolean _flag = _service.prepareToCreateEPMDoc(string);
	}
	/*public static void linkcreation(String string) throws WTException
	{
		_TestServiceImplnewtest _service = new ext.newspace.test._TestServiceImplnewtest();
		boolean _flag = _service.linkcreation(string);
	}*/
	public static void reflinkcreation(String string) throws WTException
	{
		_TestServiceImplnewtest _service = new ext.newspace.test._TestServiceImplnewtest();
		boolean _flag = _service.reflinkcreation(string);
	}
	public static void epmreflinkcreation(String string) throws WTException
	{
		_TestServiceImplnewtest _service = new ext.newspace.test._TestServiceImplnewtest();
		boolean _flag = _service.epmreflinkcreation(string);
	}
	public static void wtreflinkdeletion(String string) throws WTException 
	{
		_TestServiceImplnewtest _service = new ext.newspace.test._TestServiceImplnewtest();
		boolean _flag = _service.wtreflinkdeletion(string);
	}
	public static void epmlinkdeletion(String string) throws WTException 
	{
		_TestServiceImplnewtest _service = new ext.newspace.test._TestServiceImplnewtest();
		boolean _flag = _service.epmlinkdeletion(string);
	}
}
	


