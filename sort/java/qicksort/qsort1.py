import os
import random
import time



x =  [random.randint(0,100) for r in xrange(100)] # v1


# print x 
def swap(j,k):
	t = x[j]
	x[j] = x[k]
	x[k] = t
	 

def qsort(l,u):
	if (l >= u):
		return
	m = l
	for i in  range(l+1,u):
		if (x[i] < x [l]):
			swap(++m,i)
	swap(l,m)
	qsort(l, m-1)
	qsort(m +1,u)

print x
start = time.time() 


qsort(0,100)

end = time.time() - start 

print x
print "Execute Time" + str(end)

