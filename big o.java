// ข้อที่ 1 ตอน 2

int g1(int n, int a[]) {
    if (n <= 1)
        return 0;
    return a[n - 1] - a[0];
}


// ข้อ 2 

int g2(int n, int a[]) {
    int sum = 0;

    for (int i = 0; i < n; i++)
        sum += a[i];

    return sum * sum;
}


// ข้อที่ 3

int g3(int n, int a[]) {
    int s = 0;
    int prefix = 0;

    for (int i = 0; i < n; i++) {
        s += a[i] * prefix;
        prefix += a[i];
    }

    return s;
}
