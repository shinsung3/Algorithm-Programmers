def main():
    participant = ['leo', 'kiki', 'eden']
    completion = ['eden', 'kiki']
    print(solution(participant, completion))
    


def solution(participant, completion):
    answer = ''
    participant = sorted(participant)
    completion = sorted(completion)
    flag = False
    for i in range(len(completion)):
        if completion[i] != participant[i]:
            flag = True
            answer = participant[i]
            break
    if flag==False:
        answer = participant[len(participant)-1]
    return answer


if __name__ == "__main__":
	main()
