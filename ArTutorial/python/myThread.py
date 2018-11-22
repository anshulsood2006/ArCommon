import _thread
import time

def threadFunction(param1, param2):
	print(param1)
	print(param2)
	return
	
try:
	_thread.start_new_thread(threadFunction, ("Anshul","Sood"))
	_thread.start_new_thread(threadFunction, ("Karan","Ahuja"))
	time.sleep(1)
except Exception as e:
	print("Exception in thread received", e)