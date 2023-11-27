import matplotlib.pyplot as plt
import numpy as np
import pandas as pd


def main():
    data_eval = pd.read_csv('eval.csv')
    # print(data_eval.columns)
    plt.figure(figsize=(12, 6))
    for column in data_eval.columns[1:]:
        plt.plot(data_eval[data_eval.columns[0]], data_eval[column], label=column)
        plt.scatter(data_eval[data_eval.columns[0]], data_eval[column])

    plt.xlabel('Kích thước mảng')
    plt.ylabel('Thời gian (ms)')
    plt.title('So sánh các thuật toán tìm kiếm')
    plt.legend()
    plt.show()

if __name__ == '__main__':
    main()