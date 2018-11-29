import gym

class MyEnvironment(gym.Env):
	metadata = {'render.modes': ['human']}
	def __init__(self):
		print("Inside init function")
	def step(self, action):
		print("Inside step function")
	def reset(self):
		print("Inside reset function")
	def render(self, mode='human',close=False):	
		print("Inside render function")