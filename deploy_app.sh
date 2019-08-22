cd src/main/appengine
rm -rf esamay-0.0.1-SNAPSHOT.jar
cp /home/esamay_inc/microapi-esamay/target/esamay-0.0.1-SNAPSHOT.jar .
gcloud app deploy
