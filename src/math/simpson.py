N = 2
t0 = 0
u0 = 0
h = 0.25
hr = 0.1
T0 = 0
T = 1

TEMP_INDEX = 0
UI_Matrix = [[0 for x in range(100)] for y in range(100)]
VECTOR_X = [0 for x in range(100)]
LambdaGlobal = [0 for x in range(100)]


def A(t, i, j):
    a = [[0 for x in range(100)] for y in range(100)]
    a[0][0] = t / 25
    a[0][1] = 1
    a[1][0] = 0
    a[1][1] = t / 5
    return a[i][j]


def func(t, i):
    f = [0 for x in range(100)]
    f[0] = 1 + t
    f[1] = 1 - t
    return f[i]


def Simpson1(n, b1, c1, i, j):
    I = i
    J = j
    h1 = (c1 - b1) / (2 * n)
    s = A(b1, I, J) + A(c1, I, J)
    i4loop = b1 + h1
    for i4loop in range(i4loop, c1, 2 * h1):
        s = s + 4 * A(i4loop, I, J)
    i4loop = b1 + 2 * h1
    for i4loop in range(i4loop, c1, 2 * h1):
        s = s + 2 * A(i4loop, I, J)
    return s * h1 / 3


def Simpson2(n, b1, c1, i):
    I = i
    h1 = (c1 - b1) / (2 * n)
    s = func(b1, I) + func(c1, I)
    i4loop = b1 + h1
    for i4loop in range(i4loop, c1, 2 * h1):
        s = s + 4 * func(i4loop, I)
    i4loop = b1 + 2 * h1
    for i4loop in range(i4loop, c1, 2 * h1):
        s = s + 2 * func(i4loop, I)
    return s * h1 / 3


def func1(t, u, vector_lambda, Index, k):
    matrix_a = [[0 for x in range(100)] for y in range(100)]
    i = 0
    j = 0
    matrix_a[0][0] = t / 25
    matrix_a[0][1] = 1
    matrix_a[1][0] = 0
    matrix_a[1][1] = t / 5

    vector_f = [0 for x in range(100)]
    vector_f[0] = 1 + t
    vector_f[1] = 1 - t

    bolik = (T - T0) / h

    vector_u_l = [0 for x in range(100)]
    s = 0
    vector_lambda1 = [0 for x in range(100)]
    vector_lambda2 = [0 for x in range(100)]
    vector_lambda3 = [0 for x in range(100)]

    if Index == 0:
        if k > 5:
            for i in range(0, N, 1):
                vector_lambda1[i] = u + vector_lambda[i]
        else:
            for j in range(0, N, 1):
                vector_lambda[j] = u + 0;
        for i in range(0, N, 1):
            for j in range(0, N, 1):
                s += a[i][j] * vector_lambda[j]
            vector_u_l[i] = s + f[i]
            s = 0
        if k % 2 == 0:
            return vector_u_l[0]
        else:
            return vector_u_l[1]

    if Index == h:
        if k > 5:
            j = 0
            for i in range(N - 1, N * bolik, 1):
                vector_lambda2[j] = u + vector_lambda[i]
                j += 1
        else:
            for j in range(0, N, ):
                vector_lambda2[j] = u + 0
        for i in range(0, N):
            for j in range(0, N):
                s += a[i][j] * vector_lambda2[j]
            vector_u_l[i] = s + f[i]
            s = 0

        if k % 2 == 0:
            return vector_u_l[0]
        else:
            return vector_u_l[1]
    ## ДОПИШИ ЭТУ ФУНКЦИЮ


    return 1


def RK(mi, ui, ti, Index, vector_lambda):
    k = [0 for x in range(5)]
    l = [0 for x in range(5)]
    i = Index
    k1 = 0
    Index1 = Index
    for i in range(i, Index + h, hr):
        k[1] = hr * func1(ti, ui, vector_lambda, Index1, k1)
        k1 += 1
        l[1] = hr * func1(ti, ui, vector_lambda, Index1, k1)
        k1 += 1
        k[2] = hr * func1(ti + h * 0.5, ui + k[1] * 0.5, vector_lambda, Index1, k1)
        k1 += 1
        l[2] = hr * func1(ti + h * 0.5, ui + l[1] * 0.5, vector_lambda, Index1, k1)
        k1 += 1
        k[3] = hr * func1(ti + h * 0.5, ui + k[2] * 0.5, vector_lambda, Index1, k1)
        k1 += 1
        l[3] = hr * func1(ti + h * 0.5, ui + l[2] * 0.5, vector_lambda, Index1, k1)
        k1 += 1
        k[4] = hr * func1(ti + h, ui + k[3], vector_lambda, Index1, k1)
        k1 += 1
        l[4] = hr * func1(ti + h, ui + l[3], vector_lambda, Index1, k1)
        k1 += 1
        ui += (k[1] + 2.0 * k[2] + 2.0 * k[3] + k[4]) / 6.0
        mi += (l[1] + 2.0 * l[2] + 2.0 * l[3] + l[4]) / 6.0
        ti += hr
        UI_Matrix[TEMP_INDEX][0] = ui
        UI_Matrix[TEMP_INDEX][1] = mi
        TEMP_INDEX += 1

        print("i=" + i + "    " + "u1=" + ui + "    " + "u2=" + mi + "\n")
        # не знаю как сделать
        # write_file << i << "   " << ui << "   " << mi << "    " << endl;
    return ti, ui, mi


## main start

# initialize start variables
b = [[0 for x in range(10)] for y in range(10)]
c = [[0 for x in range(10)] for y in range(10)]
d = [0 for x in range(10)]
Q = [[0 for x in range(100)] for y in range(100)]
f = [0 for x in range(10)]
G = [0 for x in range(10)]
a = [[0 for x in range(100)] for y in range(100)]
u_l = [0 for x in range(100)]

vector_lambda = [0 for x in range(100)]
v = [0 for x in range(100)]
z = 0
y = 0
s = 0
g = [[0 for x in range(100)] for y in range(100)]
x1 = 0

# cycles args
n = 0
i = 0
j = 0

print("B matr:\n")
for i in range(0, N):
    for j in range(0, N):
        b[i][j] = input()

print("C matr:\n")
for i in range(0, N):
    for j in range(0, N):
        c[i][j] = input()

D = [100][100]
b1 = 0
c1 = 0
K = 1
p = 0
I = 1
bolik = (T - T0) / h

# may unnecessary
for i in range(0, N * bolik):
    for j in range(0, N * bolik):
        Q[i][j] = 0

print("n=")
n = input()
b1 = T0
c1 = h
S = bolik * N - N

while c1 <= T:
    i = N * (p + 1)
    for i in range(i, (p + 2) * N, 1):
        j = p * N
        for j in range(j, N * (p + 1), 1):
            Q[i][j] = Simpson1(n, b1, c1, i - (N * (p + 1)), j - p * N)
            if i >= (bolik - 1) * N and j >= (bolik - 1) * N:
                k = i - (bolik - 1) * N - N
                Q[k][j] = Simpson1(n, b1, c1, i - (N * (p + 1)), j - p * N)

    p += 1
    K += 1
    b1 = c1
    c1 = K * h

b1 = T0
c1 = h
K = 1
p = 0

while c1 <= T:
    i = N * p
    for i in range(i, (p + 1) * N):
        f[i] = Simpson2(n, b1, c1, i - N * p)
    K += 1
    b1 = c1
    c1 = K * h
    p += 1

j = 0
i = 0

for i in range(0, N * bolik):
    for j in range(0, N * bolik):
        if i - j == 2:
            Q[i][j] = Q[i][j] + 1
        if i < N and j >= (bolik - 1) * N:
            while j <= bolik * N:
                Q[i][j] = Q[i][j] + 1
                i += 1
                j += 1

print("Q[][]:\n")

j = 0
i = 0
for i in range(0, N * bolik):
    for j in range(0, N * bolik):
        print(Q[i][j] + "   ")
    print("\n")

Q1 = [[0 for x in range(100)] for y in range(100)]
i = 0

for i in range(0, N):
    s = 0
    j = bolik * N - N
    for j in range(j, N * bolik):
        s = 0
        K = 0
        for K in range(0, N):
            s += c[i][K] * Q[K][j]
        Q1[i][j] = s * h
        s = 0

i = 0
for i in range(0, N):
    j = bolik * N - N
    for j in range(j, N * bolik):
        Q[i][j] = Q1[i][j]

i = 0
j = 0

for i in range(0, N):
    for j in range(0, N):
        Q[i][j] = b[i][j] * h

i = N
j = 0
for i in range(0, bolik * N):
    for j in range(0, bolik * N):
        if i == j:
            Q[i][j] = -1

print("Q[][]:\n")

i = 0
j = 0
for i in range(0, bolik * N):
    for j in range(0, bolik * N):
        print(Q[i][j] + "   ")
    print("\n")

# кері матрица Q
matrix_m = [range(10)][range(10)]

i = 0
j = 0

for i in range(0, N * bolik):
    matrix_m[i][i] = 1
    for j in range(0, N * bolik):
        if i != j:
            matrix_m[i][j] = 0

flag = 1

i = 0

for i in range(0, N * bolik):
    temp = Q[i][i]
    if temp == 0:
        flag = 0
        break
    j = 0
    for j in range(0, N * bolik):
        Q[i][j] = Q[i][j] / temp
        matrix_m[i][j] = matrix_m[i][j] / temp

    k4loop = 0
    for k in range(0, N * bolik):
        if k != i:
            temp = Q[k][i]
            j = 0
            for j in range(0, N * bolik):
                Q[k][j] = Q[k][j] - temp * Q[i][j]
                matrix_m[k][j] = matrix_m[k][j] - temp * matrix_m[i][j]

if flag == 0:
    print("keri matrysa tabilmadi\n")

i = 0
j = 0

for i in range(0, bolik * N):
    for j in range(0, bolik * N):
        Q[i][j] = matrix_m[i][j]

i = 0
j = 0
print("keri Q[][]:\n")
for i in range(0, bolik * N):
    for j in range(0, bolik * N):
        print(Q[i][j] + "     ")
    print("\n")

i = 0
# f вектор
print("f vector:")
for i in range(0, N * bolik):
    print(f[i] + "   ")
print("\n")

i = 0
j = 0
# лямбда

for i in range(0, bolik * N):
    for j in range(0, bolik * N):
        s = 0
        k4loop = 0
        for k4loop in range(0, bolik * N):
            s += Q[i][j] * f[k4loop]
    vector_lambda[i] = s

print("lambda[] :\n")
i = 0
for i in range(0, bolik * N):
    print(vector_lambda[i] + "     ")
    LambdaGlobal[i] = vector_lambda[i]
print("\n")

ti = t0
ui = u0
mi = u0
j = 0
wek_bolik = 0
for wek_bolik in range(0, T, h):
    Index = wek_bolik
    RK(mi, ui, ti, Index, vector_lambda)

tempI = 0
i = 0
for i in range(0, 8, 2):
    VECTOR_X[i] = LambdaGlobal[i] + UI_Matrix[tempI * 2][0] + UI_Matrix[tempI * 2 + 1][0];
    VECTOR_X[i + 1] = LambdaGlobal[i + 1] + UI_Matrix[tempI * 2][1] + UI_Matrix[tempI * 2 + 1][1]
    print("x1[" + i + "]=" + VECTOR_X[i] + "    " + "x2[" + i + 1 + "]=" + VECTOR_X[i + 1] + "    \n")
    tempI += 1
    # не знаю как сделать
    # write_file <<i << "x1[" << i << "]=" << x[i] << "    " << "x2[" << i + 1 << "]=" << x[i + 1] << "    " << endl;

# не знаю как сделать
# system("gnuplot -p -e \"plot 'sizu.dat' using 1:3 title 'colum' with linespoints\"");
