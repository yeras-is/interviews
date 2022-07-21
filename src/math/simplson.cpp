#include<iostream>
#include<math.h>
#include<stdio.h>
#include<fstream>
using namespace std;
#define N 2
#define t0 0
#define u0 0
#define h 0.25
#define hr 0.1
#define T0 0
#define T 1

int tempIndex = 0;
long double ui_array[100][100];
long double x[100];
double lambdaGlobal[100];

ofstream write_file("sizu.dat");
double A(double t, int i, int j) {
  double a[100][100];
  a[0][0] = t/25;
  a[0][1] = 1;
  a[1][0] = 0;
  a[1][1] = t/5;

  return a[i][j];
}

double func(double t, int i) {
  double f[100];
  f[0] = 1+t;
  f[1] = 1-t;
  return f[i];
}

double Simpson1(int n, double b1, double c1, double i, double j) {
  double s = 0, h1, s1 = 0;
  double I, J;
  I = i;
  J = j;
  h1 = (c1 - b1) / (2 * n);
  s = A(b1, I, J) + A(c1, I, J);
  for (i = b1 + h1; i < c1; i += 2 * h1) {
    s = s + 4 * A(i, I, J);
  }
  for (i = b1 + 2 * h1; i < c1; i += 2 * h1) {
    s = s + 2 * A(i, I, J);
  }
  return s * h1 / 3;
}

double Simpson2(int n, double b1, double c1, double i) {
  double s = 0, h1, s1 = 0;
  double I;
  I = i;
  h1 = (c1 - b1) / (2 * n);
  s = func(b1, I) + func(c1, I);
  for (i = b1 + h1; i < c1; i += 2 * h1) {
    s = s + 4 * func(i, I);
  }
  for (i = b1 + 2 * h1; i < c1; i += 2 * h1) {
    s = s + 2 * func(i, I);
  }
  return s * h1 / 3;
}

double func1(double t, double u, double lambda[], double Index, int k) {
  double a[100][100];
  int i, j;
  a[0][0] = t/25;
  a[0][1] = 1;
  a[1][0] = 0;
  a[1][1] = t/5;

  double f[100];
  f[0] = 1+t;
  f[1] = 1-t;
  double bolik = (T - T0) / h;
  double u_l[100], s = 0, lambda1[100], lambda2[100], lambda3[100];
  if (Index == 0) {
    if (k > 5) {
      for (i = 0; i < N; i++) {
        lambda1[i] = u + lambda[i];
      }
    }
    else {
      for (j = 0; j < N; j++) {
        lambda[j] = u + 0;
      }
    }
    for (i = 0; i < N; i++) {
      for (j = 0; j < N; j++) {
        s += a[i][j] * lambda[j];
      }
      u_l[i] = s + f[i];
      s = 0;
    }
    if (k % 2 == 0)
      return u_l[0];
    else
      return u_l[1];

  }
  if (Index == h) {
    if (k > 5) {
      j = 0;
      for (i = N - 1; i < N * bolik; i++) {
        lambda2[j] = u + lambda[i];
        j++;
      }
    }
    else {
      for (j = 0; j < N; j++) {
        lambda2[j] = u + 0;
      }
    }
    for (i = 0; i < N; i++) {
      for (j = 0; j < N; j++) {
        s += a[i][j] * lambda2[j];
      }
      u_l[i] = s + f[i];
      s = 0;
    }
    if (k % 2 == 0)
      return u_l[0];
    else
      return u_l[1];

  }
  if (Index == 2 * h) {
    if (k > 5) {
      j = 0;
      for (i = N * bolik - N - 1; i < N * bolik; i++) {
        lambda3[j] = u + lambda[i];
        j++;
      }
    }
    else {
      for (j = 0; j < N; j++) {
        lambda[j] = u + 0;
      }
    }
    for (i = 0; i < N; i++) {
      for (j = 0; j < N; j++) {
        s += a[i][j] * lambda[j];
      }
      u_l[i] = s + f[i];
      s = 0;
    }
    if (k % 2 == 0)
      return u_l[0];
    else
      return u_l[1];

  }
}

double RK(long double mi, long double ui, long double ti, double Index, double lambda[]) {
  long double k[5], l[5];
  double i, j;
  int k1 = 0;
  double Index1 = Index;
  for (i = Index; i < Index + h; i += hr) {
    k[1] = hr * func1(ti, ui, lambda, Index1, k1); k1++;
    l[1] = hr * func1(ti, ui, lambda, Index1, k1); k1++;
    k[2] = hr * func1(ti + h * 0.5, ui + k[1] * 0.5, lambda, Index1, k1); k1++;
    l[2] = hr * func1(ti + h * 0.5, ui + l[1] * 0.5, lambda, Index1, k1); k1++;
    k[3] = hr * func1(ti + h * 0.5, ui + k[2] * 0.5, lambda, Index1, k1); k1++;
    l[3] = hr * func1(ti + h * 0.5, ui + l[2] * 0.5, lambda, Index1, k1); k1++;
    k[4] = hr * func1(ti + h, ui + k[3], lambda, Index1, k1); k1++;
    l[4] = hr * func1(ti + h, ui + l[3], lambda, Index1, k1); k1++;
    ui += (k[1] + 2.0 * k[2] + 2.0 * k[3] + k[4]) / 6.0;
    mi += (l[1] + 2.0 * l[2] + 2.0 * l[3] + l[4]) / 6.0;
    ti += hr;
    ui_array[tempIndex][0] = ui;
    ui_array[tempIndex][1] = mi;
    tempIndex++;


    cout << "i=" << i << "    " << "u1=" << ui << "    " << "u2=" << mi << endl;
    write_file << i << "   " << ui << "   " << mi << "    " << endl;
  }

  return ti, ui, mi;

}

void main() {
  double b[10][10], c[10][10], d[10], Q[100][100], f[10], G[10], a[100][100], u_l[100];
  double lambda[100];
  int n, i, j;
  double v[100], z, y, s = 0, g[100][100], x1;

  cout << "B matr:" << endl;
  for (i = 0; i < N; i++) {
    for (j = 0; j < N; j++) {
      cin >> b[i][j];
    }
  }

  cout << "C matr:" << endl;
  for (i = 0; i < N; i++) {
    for (j = 0; j < N; j++) {
      cin >> c[i][j];
    }
  }

  double D[100][100], b1, c1;
  int K = 1, I = 1, p = 0, bolik, M;
  bolik = (T - T0) / h;
  for (i = 0; i < N * bolik; i++) {
    for (j = 0; j < N * bolik; j++) {
      Q[i][j] = 0;
    }
  }

  cout << "n=";
  cin >> n;
  b1 = T0;
  c1 = h;
  int S = bolik * N - N, k;
  while (c1 <= T) {
    for (i = N * (p + 1); i < (p + 2) * N; i++) {
      for (j = p * N; j < N * (p + 1); j++) {

        Q[i][j] = Simpson1(n, b1, c1, i - (N * (p + 1)), j - p * N);
        if (i >= (bolik - 1) * N && j >= (bolik - 1) * N) {
          k = i - (bolik - 1) * N - N;
          Q[k][j] = Simpson1(n, b1, c1, i - (N * (p + 1)), j - p * N);

        }
      }
    }

    p++;
    K++;
    b1 = c1;
    c1 = K * h;

  }



  b1 = T0;
  c1 = h;
  K = 1;
  p = 0;
  while (c1 <= T) {
    for (i = N * p; i < (p + 1) * N; i++) {

      f[i] = Simpson2(n, b1, c1, i - N * p);
    }

    K++;
    b1 = c1;
    c1 = K * h;
    p++;
  }


  for (j = 0; j < N * bolik; j++) {
    for (i = 0; i < N * bolik; i++) {
      if (i - j == 2)
      {
        Q[i][j] = Q[i][j] + 1;
      }
      if (i < N && j >= (bolik - 1) * N) {
        while (j <= bolik * N) {

          Q[i][j] = Q[i][j] + 1;
          i++; j++;
        }

      }

    }

  }
  cout << "Q[][]:" << endl;
  for (i = 0; i < N * bolik; i++) {
    for (j = 0; j < N * bolik; j++) {
      cout << Q[i][j] << "   ";
    }
    cout << endl;
  }
  s = 0;
  double Q1[100][100];
  for (i = 0; i < N; i++) {
    s = 0;
    for (j = bolik * N - N; j < N * bolik; j++) {
      s = 0;
      for (K = 0; K < N; K++) {
        s += c[i][K] * Q[K][j];

      }
      Q1[i][j] = s * h;
      s = 0;

    }

  }

  for (i = 0; i < N; i++) {

    for (j = bolik * N - N; j < N * bolik; j++) {
      Q[i][j] = Q1[i][j];
    }
  }

  for (i = 0; i < N; i++) {
    for (j = 0; j < N; j++) {
      Q[i][j] = b[i][j] * h;
    }
  }
  for (i = N; i < bolik * N; i++) {
    for (j = 0; j < bolik * N; j++) {
      if (i == j)
        Q[i][j] = -1;
    }
  }

  cout << "Q[][]:" << endl;
  for (i = 0; i < N * bolik; i++) {
    for (j = 0; j < N * bolik; j++) {
      cout << Q[i][j] << "   ";
    }
    cout << endl;
  }



  // TODO
  //кері матрица Q
  float m[10][10];
  int flag;
  float temp;

  for (i = 0; i < N * bolik; i++) {
    m[i][i] = 1;
    for (j = 0; j < N * bolik; j++)
    {
      if (i != j)
        m[i][j] = 0;
    }
  }
  flag = 1;

  for (i = 0; i < N * bolik; i++){
    temp = Q[i][i];
    if (temp == 0)
    {
      flag = 0;
      break;
    }
    for (j = 0; j < N * bolik; j++)
    {
      Q[i][j] = Q[i][j] / temp;
      m[i][j] = m[i][j] / temp;
    }
    for (k = 0; k < N * bolik; k++)

    {
      if (k != i)
      {
        temp = Q[k][i];
        for (j = 0; j < N * bolik; j++)
        {
          Q[k][j] = Q[k][j] - temp * Q[i][j];
          m[k][j] = m[k][j] - temp * m[i][j];
        }

      }
    }
  }


  if (flag == 0)
    printf("keri matrysa tabilmadi");
  for (i = 0; i < N * bolik; i++) {
    for (j = 0; j < N * bolik; j++) {
      Q[i][j] = m[i][j];
    }
  }
  cout << "keri Q[][]:" << endl;
  for (i = 0; i < N * bolik; i++) {
    for (j = 0; j < N * bolik; j++) {
      cout << Q[i][j] << "     ";
    }
    cout << endl;
  }
  //f вектор
  cout << "f vector:" << endl;
  for (i = 0; i < N * bolik; i++) {
    cout << f[i] << "   ";
  }
  cout << endl;
  //лямбда
  for (i = 0; i < bolik * N; i++) {
    for (j = 0; j < bolik * N; j++) {
      s = 0;
      for (k = 0; k < bolik * N; k++) {
        s += Q[i][j] * f[k];
      }

    }
    lambda[i] = s;

  }
  cout << "lambda[] :" << endl;
  for (i = 0; i < bolik * N; i++) {
    cout << lambda[i] << "     ";
    lambdaGlobal[i] = lambda[i];
  }
  cout << endl;
  double ui, ti, mi;
  int Index;
  ti = t0;
  ui = u0;
  mi = u0;
  j = 0;
  double wek_bolik;
  for (wek_bolik = 0; wek_bolik < T; wek_bolik += h) {
    double Index = wek_bolik;
  }

  int tempI = 0;
  for (int i = 0; i < 8; i += 2) { //step
    x[i] = lambdaGlobal[i] + ui_array[tempI * 2][0] + ui_array[tempI * 2 + 1][0];
    x[i + 1] = lambdaGlobal[i + 1] + ui_array[tempI * 2][1] + ui_array[tempI * 2 + 1][1];
    cout << "x1[" << i << "]=" << x[i] << "    " << "x2[" << i + 1 << "]=" << x[i + 1] << "    " << endl;
    tempI++;
    write_file <<i << "x1[" << i << "]=" << x[i] << "    " << "x2[" << i + 1 << "]=" << x[i + 1] << "    " << endl;
  }


  system("gnuplot -p -e \"plot 'sizu.dat' using 1:3 title 'colum' with linespoints\"");
}
