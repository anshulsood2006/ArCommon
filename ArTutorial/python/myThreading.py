import threading
import time

class myThreading(threading.Thread):
	
	def __init__(self, param1, param2):
		threading.Thread.__init__(self)
		self.param1 = param1
		self.param2 = param2
	
	def run(self):
		print(self.param1)
		print(self.param2)
		return
	
try:
	thread1 = myThreading("Anshul","Sood")
	thread2 = myThreading("Karan","Ahuja")
	thread1.start()
	thread2.start()
	time.sleep(1)
except Exception as e:
	print("Exception in thread received", e)