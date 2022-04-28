# This is a sample Python script.
from itertools import count
from random import random
import pyspark

def inside(p):
    x, y = random.random(), random.random()
    return x*x + y*y < 1


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.
    NUM_SAMPLES =10
    count = sc.parallelize(range(0, NUM_SAMPLES)) \
             .filter(inside).count();
    print("Pi is roughly %f" % (4.0 * count / NUM_SAMPLES))

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print_hi('PyCharm')

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
