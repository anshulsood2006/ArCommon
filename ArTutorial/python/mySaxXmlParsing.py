import xml.sax
import os

class MyContentHandler(xml.sax.ContentHandler):
	def __init__(self):
		self.CurrentData = ""
		self.name = ""
		self.age = 0
		self.gender = ""
		return
		
	def startElement(self, tag, attributes):
		self.CurrentData = tag
		if (tag == "member"):
			print("****Member****")
		return
	
	def endElement(self, tag):
		if (self.CurrentData  == "name"):
			print("Name = ",self.name)
		if (self.CurrentData  == "age"):
			print("Age = ",self.age)
		if (self.CurrentData  == "gender"):
			print("Gender = ",self.gender)
		self.CurrentData = ""
		return
		
	def characters(self, content):
		if (self.CurrentData  == "name"):
			self.name = content
		if (self.CurrentData  == "age"):
			self.age = content
		if (self.CurrentData  == "gender"):
			self.gender = content
		return
	
parser = xml.sax.make_parser()
parser.setFeature(xml.sax.handler.feature_namespaces, 0)
parser.setContentHandler(MyContentHandler())
path = "file:///"+os.getcwd()+"/family.xml"
parser.parse(path)
		
		