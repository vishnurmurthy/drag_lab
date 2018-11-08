import numpy as np
import pandas as pd

df = pd.read_csv('part1data.csv')
v = [x for x in df['Smoothened v[m/s]']]
a = [x for x in df['Smoothened a[m/s^2]']]
g = 9.81 #m/s^2

alpha11 = sum([i**2 for i in v])
alpha21 = sum([i**3 for i in v])
alpha22 = sum([i**4 for i in v])

beta1 = sum([(g-a[x])*(v[x]) for x in range(len(a))])
beta2 = sum([(g-a[x])*(v[x])*(v[x]) for x in range(len(a))])

alpha = np.array([[alpha11, alpha21], [alpha21, alpha22]])
beta = np.array([beta1, beta2])

C = np.dot(np.linalg.inv(alpha), beta)
print(C)