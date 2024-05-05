a = []
n = int(input("Enter size of array= "))
for i in range(n):
    a.append(int(input("Enter value= ")))

for i in range(n):
    minidx = i
    for j in range(i+1, n):
        if a[minidx]> a[j]:
            minidx = j
    a[i], a[minidx] = a[minidx], a[i]
    
print("Selection Sort: ", a)