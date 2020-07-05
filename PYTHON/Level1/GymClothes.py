def main():
    n = 8
    lost = [1, 2, 4, 5, 6]
    reserve = [3, 4, 6]
    a = solution(n, lost, reserve)
    print(a)


def solution(n, lost, reserve):
    answer = int(n)-len(lost)
    lost = sorted(lost)
    reserve = sorted(reserve)
    for i in range(1, n+1):
        if i in lost:
            if i in reserve:  # 잃어버렸지만 여분도 있는 학생
                answer += 1
                reserve.remove(i)
                lost.remove(i)
    for i in lost:
        left = int(i-1)
        right = int(i+1)
        for j in reserve:
            if left == int(j) or right == int(j):
                answer += 1
                reserve.remove(j)
                break
    return answer


if __name__ == "__main__":
	main()