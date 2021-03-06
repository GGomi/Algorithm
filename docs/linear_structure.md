# 선형자료구조

# 목차
- [1. 랜덤 접근가능](#랜덤-접근가능)
  - [1.1 배열](#배열)
  - [1.2 해시](#해시)
- [2. 랜덤 접근불가능](#랜덤-접근불가능)
  - [2.1 스택](#스택)
  - [2.2 큐](#큐)
  - [2.3 데크](#데크)
  - [2.4 링크드리스트](#링크드리스트)
- [3. 선형자료 탐색법](#선형자료-탐색법)
  - [3.1 순차 탐색](#순차-탐색)
  - [3.2 이분 탐색](#이분-탐색)

---

# 랜덤 접근가능
## 배열
- 각 원소의 주소가 연속적으로 배치되어있는 구조
- 특정 `index`의 값을 가져오는 것은 `index`를 알고있으면 바로 접근가능하기 때문에 `O(1)`이다.
- 값을 찾는 것은 배열 `index`마다 확인해야하기 때문에 `O(n)`(1차원 배열)이다.
- 원소의 삽입, 삭제은 배열의 길이를 늘리거나 줄여서 하나씩 값을 옮겨주어야 하기 때문에  `O(n)`이라는 시간이 걸린다.
## 해시
- 해시는 해시함수로 구현되며, 해시함수에 키값을 넣어 주소값을 얻고, 그 주소에 위치한 버킷에 저장된 데이터를 가져오는 방식을 말한다.
- 검색성능이 이론상으로 `O(1)`인 자료구조이다.
- 해쉬충돌이 발생할 수 있다는 단점이 있다. 이 경우에 `O(n)`의 시간이 걸릴 수 있다.
## HashMap
- 키에 대한 해시 값을 사용하여 값을 저장하고 조회하며, 키-값 쌍의 개수에 따라 동적으로 크기가 증가하는 `associate array` 이다.
- HashMap의 해시충돌을 방지하기위해서 Seperate Chaining, 보조 해시함수를 사용한다.
- Java 8에서는 Seperate Chaining을 위해서 링크드리스트가 아닌 트리를 사용하기도 한다.(해시버킷에 할당된 키-값 쌍의 개수가 기준치 이상 넘어가면 트리로 변경한다.)

---
# 랜덤 접근불가능
모든 자료에 `O(1)`로 접근이 보장되지 않는 자료구조

## 스택
- 차곡차곡 데이터가 쌓여가는 구조
- 스택은 제일 위의 데이터만 알 수 있다.
- 후입선출(LIFO)
- 컴퓨터에서 많이 사용되는 자료구조 중 하나이다.
- 참조지역성(한번 참조된 것은 또 다시 참조될 확률이 높다)라는 특성을 활용할 수 있는 최고의 자료구조는 스택이다.
- 시간복잡도
    - pop() : 가장 위의 데이터를 출력하므로 O(1)
    - push() : 가장 위로 들어가므로 O(1)
    - peek() : pop과 같음 
    - size() : 배열로 구현할 시 O(1), 연결리스트로 구현할 시 O(n)
- [소스코드](/src/main/java/com/essri/algorithm/StackExample.java)
## 큐
먼저 들어간 자료가 먼저 나오는 자료구조. 선입선출(先入先出) 구조라고도 한다. 자료를 넣는 Enqueue 함수와 자료를 빼내는 Dequeue 함수를 가진다.

배열로 하는 경우에는 보통 순환 큐라고 해서 맨 끝과 앞을 연결(나머지 연산자 % 이용)하는 방식으로 구현한다. 소스는 다음과 같다.
```C
void enqueue(int);
int dequeue();

struct linkedList
{
    int value;
    struct linkedList *next;
};
struct linkedList *front; //큐의 맨 앞을 가리킨다.
struct linkedList *back; //큐의 맨 뒤를 가리킨다.

void enqueue(int n) //큐에 자료를 넣는 함수
{
    if(front == NULL) //큐가 비어 있을 경우
    {
        *front = {n, NULL}; //맨 앞에 자료를 넣고
        back = front; //맨 뒤와 맨 앞을 같게 한다.
    }
    else
    {
        back -> *next = {n, NULL}; //맨 뒤 다음에 자료를 넣는다.
        back = back -> next; //넣은 자료를 맨 뒤로 한다.
    }
}

int dequeue() //큐에서 자료를 빼는 함수
{
    int res = front -> value;
    front = front -> next;
    return res;
}
```
## 데크
- 양쪽 끝에서 삽입과 삭제가 모두 가능하다. 
- 보통 입력이나 출력 중 하나를 한쪽 입구만 가능하게 제한하는 형태가 많이 쓰인다.

## 링크드리스트
- 단순 연결리스트, 이중 연결리스트 등이 있다.
- 각각의 노드로 구성되어있고, 단순연결리스트의 경우는 다음 노드의 주소를 포함하고있다. (이중연결리스트는 이전주소까지)
- 시간복잡도 
    - 중간 삽입, 삭제 시의 시간복잡도는 O(1)이다.
    - 탐색은 O(n)이다. (처음부터 끝까지 모든 노드를 탐색해야하기 때문)


# 선형자료 탐색법
## 순차 탐색
- 처음부터 끝까지 전부 탐색하는 방법, 당연히 `O(n)`의 시간

## 이분 탐색
- 가운데에서 시작해서 매번 일정한 조건에 따라 어떤방향으로 가운데 값으로 탐색할지 결정하는 알고리즘이다.
- `이분탐색`은 **정렬**되어있는 상황에서만 사용할 수 있는 탐색방법으로 `O(logn)`의 시간복잡도를 기대할 수 있다.
- [소스코드](/src/main/java/com/essri/algorithm/BinarySearch.java)

