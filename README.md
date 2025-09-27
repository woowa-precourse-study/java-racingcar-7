# java-racingcar-precourse 기능 목록

## InputView: 입력 받기

## **RacingCarService: winners 리스트 반환**

- 입력 검증(CarNameVerifier, RoundVerifier)
    - CarNameVerifier:
        - 예외: strip → 이름.length() > 5
        - 예외: isblank
    - RoundVerifier:
        - 예외: 숫자가 아닌 값이 들어올 때
        - ~~예외: 횟수가 int 범위를 벗어날 때~~ 상식적으로 게임 라운드가 int범위를 넘기지 않을 거라고 판단.
        - 예외: 음수일 때
- Car 생성
- ‘실행 결과' 출력 - 이거 Racing에 들어있으면 좋겠는데
- **Racing - 여기도 좀 리팩토링 하고 싶은데**
    - round만큼 반복
        - RandomMover
        - 라운드 별 실행 결과 출력
- WinnersFinder

## ResultView

