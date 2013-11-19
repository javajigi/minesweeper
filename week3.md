



week3
11월 19일
================

2x2
- numberOfMine 수정 
- 이중 for문 제거 하는 리팩토링 
- 패배시 grid All open(gridPint())


3x3(선택사항)
- grid를 open(2,2)한다면 return 0~8까지


print 경우의 수
- Mine : isopen && ismine
- 숫자 : isopen && !ismine
		
- Closed : !isopen && !isflag
- Flag : !isopen && isflag
