week5
12월 10일


- 리팩토링
	-grid.openSquare()
	-row.openSquare()
	- ' squares[j].getNumOfNearMines() == 0 ' 를  square에게 위임
	- grid.printConsole() 이중 for문 제거 
	- increaseNearNumberOfMine에서 바운더리컨디션 체크부분 정리(깔끔하게)

- grid 초기화
	- grid row, col 설정
	- 지뢰를 몇개 심을지 설정
	- 지뢰를 랜덤하게 뿌리기

- minesweeper의 main Class생성
	- UI와 연결 

- 성능이슈 
	- 현재 openSquare()는 '무식하게' 전체 순회를 한다. O(n^2)
	- openSquare()일때 이전 방문한 square는 방문하지 않는다.

- gameover 조건 재정의
	- close 상태에 있는 square가 모두 마인일 경우 '자동' 승리
	- openAll() 없애기 
