#! /bin/bash
if [ -z "$PROACTIVE" ]
then
workingDir=`dirname $0`
PROACTIVE=$workingDir/../../../.
CLASSPATH=.
fi
. $PROACTIVE/scripts/unix/env.sh

java -Djava.security.policy=proactive.java.policy -Xms64m -Xmx1024m org.objectweb.proactive.core.body.ft.util.StartFTServer $1 $2 $3 $4 $5 $6

# DEBUG :   -Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n -Djava.compiler=NONE
