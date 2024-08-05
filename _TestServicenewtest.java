package ext.newspace.test;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.List;


import wt.content.ApplicationData;
import wt.content.ContentHolder;
import wt.content.ContentRoleType;
import wt.doc.WTDocument;
import wt.epm.EPMDocument;
import wt.fc.WTObject;
import wt.folder.Folder;
import wt.inf.container.WTContainer;
import wt.inf.container.WTContainerRef;
import wt.part.WTPart;
import wt.pom.PersistenceException;
import wt.util.WTException;
import wt.util.WTInvalidParameterException;
import wt.util.WTPropertyVetoException;
import wt.vc.wip.WorkInProgressException;
import wt.content.ApplicationData;

public interface _TestServicenewtest {
	String DELIMITOR = "#";

	boolean replaceAttachment(String string) throws IOException;
	boolean createDoc(String string) throws WTException;
	boolean prepareToCreateEPMDoc(String string) throws WTException, WTInvalidParameterException, WTPropertyVetoException;
	//boolean linkcreation(String string) throws WTException;
	boolean reflinkcreation(String string) throws WTException;
	boolean epmreflinkcreation(String string) throws WTException;
	boolean wtreflinkdeletion(String string) throws WTException;
	boolean epmlinkdeletion(String string) throws WTException;
    }
