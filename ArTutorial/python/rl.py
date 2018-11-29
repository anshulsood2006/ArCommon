import gym
import RLEnvironment.envs.myenvironment
env = gym.make('myenv-v0')
env.reset()
env = gym.make("Taxi-v2")
env.reset()
env.render()
print("Action Space {}".format(env.action_space))
print("State Space {}".format(env.observation_space))
