/*
* ################################################################
*
* ProActive: The Java(TM) library for Parallel, Distributed,
*            Concurrent computing with Security and Mobility
*
* Copyright (C) 1997-2002 INRIA/University of Nice-Sophia Antipolis
* Contact: proactive-support@inria.fr
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 2.1 of the License, or any later version.
*
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
* USA
*
*  Initial developer(s):               The ProActive Team
*                        http://www.inria.fr/oasis/ProActive/contacts.html
*  Contributor(s):
*
* ################################################################
*/
package nonregressiontest.activeobject.loopmixedlocation;

import nonregressiontest.activeobject.locationserver.A;
import nonregressiontest.activeobject.locationserver.MigratableA;

import org.objectweb.proactive.ProActive;
import org.objectweb.proactive.core.UniqueID;
import org.objectweb.proactive.core.body.proxy.BodyProxy;
import org.objectweb.proactive.core.mop.StubObject;
import org.objectweb.proactive.core.util.ProActiveProperties;
import org.objectweb.proactive.ext.mixedlocation.MixedLocationMetaObjectFactory;
import org.objectweb.proactive.ext.util.SimpleLocationServer;

import testsuite.manager.ProActiveFuncTestManager;

import testsuite.test.ProActiveFunctionalTest;


/**
 * @author rquilici
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class Test extends ProActiveFunctionalTest {
    A a;
    MigratableA migratableA;
    SimpleLocationServer server;
    UniqueID idA;

    public Test() {
        super("Test migration with mixed strategy",
            "Test migration with location server and forwarder");
    }

    /**
     * @see testsuite.test.FunctionalTest#action()
     */
    public void action() throws Exception {
        String serverUrl = ProActiveProperties.getLocationServerRmi();
        server = (SimpleLocationServer) ProActive.newActive(SimpleLocationServer.class.getName(),
                new Object[] { serverUrl });
        Thread.sleep(3000);
        a = (A) ProActive.newActive(A.class.getName(), new Object[] { "toto" },
                ((ProActiveFuncTestManager) manager).getSameVMNode(), null,
                MixedLocationMetaObjectFactory.newInstance());
        migratableA = (MigratableA) ProActive.newActive(MigratableA.class.getName(),
                new Object[] { "toto" },
                ((ProActiveFuncTestManager) manager).getSameVMNode(), null,
                MixedLocationMetaObjectFactory.newInstance());
        idA = ((BodyProxy) ((StubObject) a).getProxy()).getBodyID();
        migratableA.moveTo(((ProActiveFuncTestManager) manager).getLocalVMNode());
        Thread.sleep(3000);
    }

    /**
     * @see testsuite.test.AbstractTest#initTest()
     */
    public void initTest() throws Exception {
    }

    /**
     * @see testsuite.test.AbstractTest#endTest()
     */
    public void endTest() throws Exception {
    }

    public boolean postConditions() throws Exception {
        return ((server.searchObject(idA) != null) &&
        a.getName(migratableA).equals("toto"));
    }
}
