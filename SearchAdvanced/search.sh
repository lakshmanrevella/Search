
DIRNAME=`dirname $0`

BUILD_HOME=$(cd $DIRNAME/../; pwd -P)

CLASSPATH=$BUILD_HOME/lib/Search.jar

arg1=$1
arg2=$2

if [ -z "$1" ] || [ -z "$2" ]; then
        echo "Missing arguments, exiting.."
        echo "Usage : $0 arg1 arg2"
        exit 1
fi


#java -jar $CLASSPATH com.driver.Client arg1 arg2

java -jar $CLASSPATH $arg1 $arg2
