FROM openjdk:11
EXPOSE 8080
ADD target/Comprehensive_Ass_Emp_App-0.0.1-SNAPSHOT.jar Comprehensive_Ass_Emp_App-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Comprehensive_Ass_Emp_App-0.0.1-SNAPSHOT.jar"]