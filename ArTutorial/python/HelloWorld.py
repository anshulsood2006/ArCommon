#!/usr/bin/python
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
print("What is your name")
z=input()
print(z)