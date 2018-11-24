#!/usr/bin/python
import time

import dir1.dir11.file11, dir1.dir11.file12, dir1.dir11.file13

#import psycopg2
import mysql.connector as mysql

import smtplib
from smtplib import SMTPException

import _thread
import threading

def printThis(str):
	print(str)
	return
	
def myFunction( name="Anshul", age="12"):
	print("Name", name)
	print("Age", age)	
	return
	
def varArgs(str, *vartuple):
	print(str)
	for x in vartuple:
		print(x)
	return
def threadFunction(param1, param2):
	print("Hello this is ankur")
	print(param1)
	print(param2)
	return
	
def myLambdaFunction(n):
	return lambda a : a * n
   			
ticks = time.time()
print("Number of ticks since 12:00am, January 1, 1970:", ticks)
print("Hello, World!")
if 5>2:
	print("Five is greater than two!")
#This is a comment
"""This is just a documentation"""
x=51
print(type(x))
y=21
print("The sum of x and y is")
print(y + x)
x="Anshul Sood"
print(x)
print("The value of x is: "+x)
print(type(x))
j=12
k=7.8
l=1j
m=-3456
print(l)
print(type(j))
print(type(k))
print(type(l))
print(type(m))
k=complex(12)
print(k)
z=str("Zakir Hussain")
print(z[10])
print(z[1:10])
z=str(" Zakir Hussain   ")
print(z.strip())
print(len(z.strip()))
print(z.replace("aki","ube"))
z="ANshUL SooD"
print(z.lower())
print(z.upper())
z="Anshul , Sood,is, A , good"
print(z.split(","))
var = 100
if ( var == 100 ) : print("Value of expression is 100")
if var: 
	print("Value of expression is 100")
var = 200
if (var == 20): 
	print("Value of expression is 20")
else:
	print("Value of expression is not 20")
fruits = ['Apple', 'Banana', 'Orange']
for fruit in fruits:
	print(fruit)	
for index in range(len(fruits)):
	print(fruits[index])
for num in range(10,20):
	print(num)
var = len(fruits) - 1 
while var > 0:
	print(fruits[var])
	if var == 2:
		break
	var = var - 1	
list1 = ('physics', 'chemistry', 1997, 2000)
for anshul in list1:
	print(anshul)
list1 = ['physics', 'chemistry', 1997, 2000]
list1[3] = 'sood'
print(list1)
for anshul in list1:
	print(anshul)
tup1 = ('physics', 'chemistry', 1997, 2000);
print(tup1)
thisdict = {"brand":"Ford","model": "Mustang", "year": 1964}
print(thisdict.get("model"))
print(thisdict["year"])
mydict = dict({1: 'One', 2 : 'Two', 3: 'Three'})
print(mydict)
mydict = dict([(1, 'One'),(2, 'Two'),(3, 'Three')])
print(mydict)
printThis(str = "Print This String")
myFunction(age="72")
myFunction(name="This Name")
varArgs("Anshul")
varArgs("Anshul","Akhil","Abhishek")
dir1.dir11.file11.func11()
dir1.dir11.file12.func12()
dir1.dir11.file13.func13()
print("What is your name")
#z=eval(input("Hello"))
print(z)
#conn = psycopg2.connect(database = "arbid", user = "postgres", password = "thule", host = "127.0.0.1", port = "5432")
conn = mysql.connect(database = "arbid", user = "root", password = "myfriendwa@123", host = "127.0.0.1", port = "3306")
try:
	cur = conn.cursor()
	print("Opened database connection")
	cur.execute('''CREATE TABLE COMPANY
	      (NAME           TEXT    NOT NULL,
	      AGE            INT     NOT NULL,
	      ADDRESS        CHAR(50),
	      SALARY         REAL);''')
	print("Table created successfully")
except Exception as err:
	print("Table already exists")
finally:
	conn.commit()
	conn.close()
	
#conn = psycopg2.connect(database = "arbid", user = "postgres", password = "thule", host = "127.0.0.1", port = "5432")
conn = mysql.connect(database = "arbid", user = "root", password = "myfriendwa@123", host = "127.0.0.1", port = "3306")
cur = conn.cursor()
cur.execute("SELECT VERSION()")
data = cur.fetchone()
print ("Database version : %s " % data)
conn.close()

#conn = psycopg2.connect(database = "arbid", user = "postgres", password = "thule", host = "127.0.0.1", port = "5432")
conn = mysql.connect(database = "arbid", user = "root", password = "myfriendwa@123", host = "127.0.0.1", port = "3306")
cur = conn.cursor()
sql = """INSERT INTO COMPANY(NAME,
	AGE, ADDRESS, SALARY)
	VALUES ('Anshul', 20, 'Noida', 20000)"""
cur.execute(sql)
# Commit your changes in the database
conn.commit()
conn.close()

#conn = psycopg2.connect(database = "arbid", user = "postgres", password = "thule", host = "127.0.0.1", port = "5432")
conn = mysql.connect(database = "arbid", user = "root", password = "myfriendwa@123", host = "127.0.0.1", port = "3306")
cur = conn.cursor()
sql = """SELECT * FROM COMPANY LIMIT 5"""
cur.execute(sql)
employees = cur.fetchall()
for employee in employees:
	print("Name: ", employee[0])
	print("Age: ", employee[1])
	print("Address: ", employee[2])
	print("Salary: ", employee[3])
	print("**********************")
conn.close()
cur.close()


'''
sender = 'sender@gmail.com'
receiver = ['receiver@gmail.com']
message = """
Subject: SMTP e-mail test
This is a test e-mail message sent via Python script.
"""
try:
   smtpObj = smtplib.SMTP('smtp.gmail.com',587)
   smtpObj.starttls()
   smtpObj.ehlo()
   smtpObj.login(sender,'password')
   smtpObj.sendmail(sender, receivers, message) 
   smtpObj.quit()        
   print("Successfully sent email")
except SMTPException:
   print("Error: unable to send email")
'''

try:
	_thread.start_new_thread(threadFunction, ("Anshul","Sood"))
	_thread.start_new_thread(threadFunction, ("Karan","Ahuja"))
	time.sleep(1)
	print("Khilona")
except Exception as e:
	print("Exception in thread received", e)
	
l = lambda a, b, c: a + b + c
print('Lambda l(2, 3, 4) which is lambda a, b, c: a + b + c returns: ',l(2, 3, 4))


doubler = myLambdaFunction(2)	
print(doubler(11))
tripler = myLambdaFunction(3)
print(tripler(11))