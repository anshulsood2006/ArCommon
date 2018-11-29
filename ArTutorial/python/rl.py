import gym
import RLEnvironment.envs.myenvironment
env = gym.make('myenv-v0')
env.reset()
#env.step(action)