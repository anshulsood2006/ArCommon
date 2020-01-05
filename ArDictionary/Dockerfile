#Docker file to create a docker image with ArDictionary.
FROM arubuntu:latest
MAINTAINER "Anshul Sood <anshulsood2006@gmail.com>"
RUN apt-get install -y postgresql postgresql-contrib
USER postgres
RUN /etc/init.d/postgresql start
CMD ["/usr/lib/postgresql/10/bin/postgres", "-D", "/var/lib/postgresql/10/main", "-c", "config_file=/etc/postgresql/10/main/postgresql.conf"]
EXPOSE 5432
USER root
RUN apt-get install -y openjdk-8-jdk
WORKDIR /app
COPY ./jboss/wildfly-8.1.0.Final.tar.gz /app
RUN tar -xvf /app/wildfly-8.1.0.Final.tar.gz
RUN rm -rf /app/wildfly-8.1.0.Final.tar.gz 
COPY ./ArEar/target/arear.ear /app/wildfly-8.1.0.Final/standalone/deployments
WORKDIR /
CMD ["./app/wildfly-8.1.0.Final/bin/standalone.sh","-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
