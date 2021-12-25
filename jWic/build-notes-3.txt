    1  sudo passwd root
    2  su -
    3  ls -l
    4  sudo shutdown -h now
    5  sudo apt-get git
    6  git
    7  sudo apt-get install git
    8  sudo rm /var/lib/dpkg/lock
    9  sudo apt-get install git
   10  ssh-keygen -t rsa -b 4096 -C "bbt4me@crts.com"
   11  ls -al
   12  cd .ssh
   13  ls -l
   14  cat id_rsa.pub
   15  cd ..
   16  ls -l
   17  pwd
   18  mkdir dev01
   19  cd dev01
   20  ls -l
   21  sudo apt update
   22  sudo apt upgrade
   23  java -version
   24  sudo apt install default-jre
   25  java -version
   26  sudo apt install defalut-jdk
   27  sudo apt install default-jdk
   28  javac -version
   29  sudo apt install openjdk-8-jdk
   30  java -version
   31  sudo update-alternative --config java
   32  sudo update-alternatives --config java
   33  git clone --single-branch --branch prune-it https://github.com/cf2141/jWic.git
   34  cd jWic
   35  ls -l
   36  mvn package
   37  sudo apt install maven
   38  mvn package
   39  history
   40* ls -l 
   41  history > build-notes.txt
   42  git add .
   43  git status
   44  git commit -m "added build-notes.txt
"
   45  git config --global user.email "cf2141@tgndomains.com"
   46  git config --global user.name "cf2141"
   47  git commit -m "added build-notes.txt
"
   48  git push
   49  history 
   50  cd ../..
   51  sudo groupadd tomcat
   52  sudo useradd -s /bin/false -g tomcat -d /opt/tomcat tomcat
   53  cd /tmp
   54  curl -O http://mirror.cc.columbia.edu/pub/software/apache/tomcat/tomcat-9/v9.0.10/bin/apache-tomcat-9.0.10.tar.gz
   55  sudo apt install curl
   56  curl -O http://mirror.cc.columbia.edu/pub/software/apache/tomcat/tomcat-9/v9.0.10/bin/apache-tomcat-9.0.10.tar.gz
   57  ls -l
   58  sudo mkdir /opt/tomcat
   59  sudo tar xzvf apache-tomcat-9.0.10.tar.gz -C /opt/tomcat --strip-components=1
   60  curl -O http://mirror.cc.columbia.edu/pub/software/apache/tomcat/tomcat-9/v9.0.10/bin/apache-tomcat-9.0.10.tar.gz
   61  sudo tar xzvf apache-tomcat-9.0.10.tar.gz -C /opt/tomcat --strip-components=1
   62  ls -l /home/ubuntu1804/Downloads/
   63  cp /home/ubuntu1804/Downloads/apache-tomcat-9.0.26.tar.gz .
   64  ls -l
   65  sudo tar xzvf apache-tomcat-9.0.26.tar.gz -C /opt/tomcat --strip-components=1
   66  sudo /opt/tomcat
   67  cd /opt/tomcat
   68  ls -l
   69  sudo chgrp -R tomcat /opt/tomcat
   70  sudo chmod -R g+r conf
   71  sudo chmod g+x conf
   72  sudo chown -R tomcat webapps/ work/ temp/ logs/
   73  sudo vi /etc/systemd/system/tomcat.service
   74  sudo update-alternatives --config java
   75  sudo vi /etc/systemd/system/tomcat.service
   76  sudo systemctl daemon-reload
   77  sudo systemctl start tomcat
   78  sudo systemctl status tomcat
   79  sudo ufw allow 8080
   80  http://localhost:8080
   81  sudo systemctl enable tomcat
   82  sudo vi /opt/tomcat/conf/tomcat-users.xml
   83  sudo vi /opt/tomcat/webapps/host-manager/META-INF/context.xml
   84  sudo systemctl restart tomcat
   85  sudo vi /opt/tomcat/conf/tomcat-users.xml
   86  sudo systemctl restart tomcat
   87  cd webapps
   88  su -
   89  cd /home/ubuntu1804/dev01/jWic
   90  sudo cp .target-mvn/jwic-samples/samples.war /opt/tomcat/webapps/.
   91  sudo apt-get install jedit
   92  sudo systemctl restart tomcat
   93  ls -l
   94  history > build-notes-2.txt
   95  vi build-notes-2.txt 
   96  git add .
   97  git status
   98  git commit -m "buid-notes-2"
   99  git push 
  100  mvn package
  101  history | grep cp
  102  sudo cp .target-mvn/jwic-samples/samples.war /opt/tomcat/webapps/.
  103  ls -l
  104  ls -l /opt
  105  ls -l /opt/t
  106  ls -l /opt/tomcat/
  107  ls -l /opt/tomcat/webapps/
  108  sud ls -l /opt/tomcat/webapps/
  109  sudo ls -l /opt/tomcat/webapps/
  110  df -h
  111  sudo ls -l /opt/tomcat/webapps/
  112  sudo ls -l /opt/tomcat/webapps/02-linder
  113  sudo ls -l /opt/tomcat/webapps/01-amp3s
  114  1984-bb-side16-how-to-follow-up.mp31984-bb-side16-how-to-follow-up.mp3
  115  sudo cp /opt/tomcat/webapps/01-amp3s/1984-bb-side16-how-to-follow-up.mp3 .
  116  ls -l
  117  mv 1984-bb-side16-how-to-follow-up.mp3 audio-test/
  118  ls -l
  119  sudo add-apt-repository "deb http://archive.canonical.com/ $(lsb_release -sc) partner"
  120  sudo apt update
  121  sudo apt-get install vlc -y
  122  sudo apt install libdvdnav4 libdvdread4 gstreamer1.0-plugins-bad gstreamer1.0-plugins-ugly libdvd-pkg
  123  sudo apt install ubuntu-restricted-extras
  124  ls -l
  125  history | > build-notes-3.txt
  126  git status
  127  git add .
  128  git commit -m "build-notes-3 installs codec to play mp3s"
  129  git push
  130  ls -l
  131  history > build-notes-3.txt
