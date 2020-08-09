#람다식을 활용해서 문제풀기
def solution1(strings, n):
    answer = []
    answer = sorted(sorted(strings), key=lambda x:x[n])
    return answer
# 앞에다가 정렬할 자릿수의 숫자를 앞으로 붙인 후에 정렬하기
def solution(strings, n):
    answer = []
    for i in range(len(strings)):
        strings[i] = strings[i][n] + strings[i]
    strings.sort()
    for i in strings:
        answer.append(i[1:])
    return answer

strings = ["abce", "abcd", "cdx"]
n = 2
print(solution(strings, n))
