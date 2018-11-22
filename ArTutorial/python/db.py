import mysql.connector as mysql
conn = mysql.connect(database = "arbid", user = "root", password = "myfriendwa@123", host = "127.0.0.1", port = "3306")
try:
	cur = conn.cursor()
	print("Opened database connection")
	cur.execute('''CREATE TABLE COMPANY
    	(NAME TEXT NOT NULL,
    	AGE INT NOT NULL,
    	ADDRESS CHAR(50),
    	SALARY REAL);''')
	print("Table created successfully")
except Exception as err:
	print("Table already exists")
finally:
	conn.commit()
	conn.close()