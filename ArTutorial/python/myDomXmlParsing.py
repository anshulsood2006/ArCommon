import xml.dom.minidom

dom = xml.dom.minidom.parse("family.xml")
root = dom.documentElement
if root.hasAttribute("name"):
	print(root.getAttribute("name"))
members = root.getElementsByTagName("member")
for member in members:
	print(member.getElementsByTagName("name")[0].childNodes[0].data)
	print(member.getElementsByTagName("age")[0].childNodes[0].data)
	print(member.getElementsByTagName("gender")[0].childNodes[0].data)