# 정렬알고리즘

# 목차
- 정렬 알고리즘
  - [1. 버블정렬](#버블정렬)
  - [2. 선택정렬](#선택정렬)
  - [3. 삽입정렬](#삽입정렬)
  - [4. 퀵정렬](#퀵-정렬)
  - [5. 병합정렬](#병합-정렬)
- [정렬알고리즘 시간복잡도 정리](#정렬알고리즘-시간복잡도-정리)
---
## Sorting Algorithm

### 버블정렬
- 간단하게 구현할 수 있는 코드이다.~~그만큼 느리다~~
- 사실상 공부용일뿐 실제 정렬에서 쓸 수 없을정도..
- 정렬이 되어있든 안되어있든 느리다..
- [정렬영상](https://youtu.be/Cq7SMsQBEUw)
- [소스코드](/src/main/java/com/essri/algorithm/BubbleSort.java)

### 선택정렬
- 버블정렬과 마찬가지로 쉽게 구현할 수 있지만 구리다.
- 첫번째 값을 잡고, 얘보다 뒤에 있는 모든 애들 중에 작은 값을 찾아서 바꿔주는 것이다.
- [정렬영상](https://youtu.be/92BfuxHn2XE)
- [소스코드](/src/main/java/com/essri/algorithm/SelectionSort.java)

### 삽입정렬
- 이 정렬도 구현이 쉬운 알고리즘에 속한다.
- 이름 그대로 하나씩 삽입해 나가는 형태의 정렬방식으로, 특정 값에 대해서 그 값이 맞는 위치를 찾고, 나머지는 한칸씩 밀어낸다.
- 적당히 큰 단위에선 퀵 정렬를 쓰고 자잘한 단위에선 삽입 정렬을 쓰는 방식을 사용하기도 한다.
- [정렬영상](https://youtu.be/8oJS1BMKE64)
- [소스코드](/src/main/java/com/essri/algorithm/InsertionSort.java)

### 퀵 정렬
- 하지만 퀵정렬도 항상 빠른건 아니다. 최악인 경우는 모두 역순으로 정렬되어있는 상태이다. 이때의 시간복잡도는 `O(n^2)`이 되어버린다.
- 그래도 역순으로 들어오는 경우라고해도 첫 시작 인덱스를 맨앞의 값을 쓰는 것이 아닌 아무 값이나 잡게 하면 대부분의 `O(nlogn)`을 보장받을 수 있다.
- 실제로 정렬 알고리즘을 돌렸을 때 퀵 정렬은 다른 `O(nlogn)` 알고리즘보다 캐시 히트 레이트가 높아 훨씬 더 빠르기 때문에 일반적으로 정렬의 대부분은 퀵 정렬 알고리즘을 활용한 형태를 사용한다. ~~킹갓퀵정렬~~
- Quicksort는 주어진 array 안에서 pivot을 향해 가는 left와 right 값을 비교한다. 한 array 내에서 하나의 index가 increment되는 left, right값을 가져오기 때문에 Locality of Reference 가 좋다. L1 Cache에 저장되에 있을 확률이 높기 때문에 Cache hit이 자주 난다는 뜻이다.

- 하지만 Merge sort은 매 merge 단계마다 위에 보이는 것처럼 auxiliary array가 생성이 된다. Stack에서부터 매번 데이터를 다시 불러와야 하기 때문에 cache hit이 보장되지 않는다. 이는 많은 양의 데이터를 다룰 때 무시하지 못할 기능의 제약을 줄 수 있다.
- [소스코드](/src/main/java/com/essri/algorithm/QuickSort.java)

### 병합 정렬
- 분할정복기법의 대표적인 예다.
- 분할->정복->합병
- [소스코드](/src/main/java/com/essri/algorithm/MergeSort.java)
---
## 정렬알고리즘 시간복잡도 정리
![시간복잡도정리](https://files.slack.com/files-pri/TG1SCNSVC-FGX9RGB4L/kakaotalk_photo_2019-03-13-22-27-38.png?pub_secret=8bf3fbcad3)