**구현 된 기능 요약**
1. 게임 시작
   - 프로그램이 실행되면 "숫자 야구 게임을 시작합니다."를 출력하고, 게임 루프를 실행
   컴퓨터가 서로 다른 3개의 숫자를 랜덤으로 생성하고, 사용자가 입력한 숫자와 비교
   게임 종료 후 재시작 여부 확인
   
2. 컴퓨터 숫자 생성 (generateComputerNumbers)
   - 1부터 9까지의 숫자 중 중복되지 않는 3개의 숫자를 랜덤하게 생성.
   
3. 사용자 입력 처리 및 검증
   - "숫자를 입력해주세요:" 메시지를 출력하고 사용자 입력을 받습니다.
   - 사용자 입력이 올바른지 확인: 입력값이 null이거나 비어 있지 않은지, 3자리 숫자인지, 숫자가 서로 다른지 검증.
   잘못된 입력일 경우, 오류 메시지를 출력한 뒤 프로그램 종료.
4. 숫자 비교 및 결과 출력
   - 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자를 비교:
   - 스트라이크: 위치와 숫자가 모두 같은 경우.
   - 볼: 위치는 다르지만 숫자가 존재하는 경우.
   - 낫싱: 아무 숫자도 맞지 않는 경우.
   - 결과를 문자열 형태로 반환 ("낫싱", "X볼", "X스트라이크", "X볼 Y스트라이크").
5. 게임 재시작 여부 확인
   - 게임 종료 후, "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 메시지를 출력.
   - 사용자 입력이 1 또는 2인지 검증함
   - 1 → 게임 재시작 (true 반환).
   - 2 → 게임 종료 (false 반환).
   - 잘못된 입력이면 오류 메시지 출력 후 프로그램 종료.