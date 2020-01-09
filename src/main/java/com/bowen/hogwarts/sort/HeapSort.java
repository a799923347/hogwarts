package com.bowen.hogwarts.sort;

/**
 * 堆排序
 * 基于大顶堆
 * 1. 将初始待排序关键字序列(R_1,R_2….R_n)构建成大顶堆，此堆为初始的无序区；
 * 2. 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R_1,R_2,……R_n-1)和新的有序区(R_n),且满足R[1,2…n-1]<=R[n]；
 * 3. 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R_1,R_2,……R_n-1)调整为新堆，然后再次将R[1]与
 *    无序区最后一个元素交换，得到新的无序区(R_1,R_2….R_n-2)和新的有序区(R_n-1,R_n)。不断重复此过程直到有序区的元
 *    素个数为n-1，则整个排序过程完成。
 *
 * @author zhaobaowen
 */
public class HeapSort {

  public void sort(int[] nums) {
    buildMaxHeap(nums);
    int border = nums.length;
    for (int i = nums.length - 1; i >= 0; i--) {
      // 交换堆顶最大的元素
      swap(nums, 0, i);
      border--;
      heapify(nums, 0, border);
    }
  }

  private void buildMaxHeap(int[] nums) {
    int length = nums.length;
    /*
     * 数组下标从0开始，length/2 - 1 为倒数第一个非叶子节点，此处基于完全二叉树的性质
     */
    for (int i = length / 2 - 1; i >= 0; i--) {
      heapify(nums, i, length);
    }
  }

  /**
   * 大顶堆化
   * @param nums 数组
   * @param currentRoot 当前节点
   * @param border nums数组中堆化要使用的数据边界
   */
  private void heapify(int[] nums, int currentRoot, int border) {
    int leftChild = (currentRoot << 1) + 1;
    int rightChild = (currentRoot << 1) + 2;
    int largest = currentRoot;
    if (leftChild <= border - 1 && nums[leftChild] > nums[largest]) {
      largest = leftChild;
    }
    if (rightChild <= border - 1 && nums[rightChild] > nums[largest]) {
      largest = rightChild;
    }
    // 非初始化大顶堆，在迭代维护大顶堆性质的过程中调用此方法时，由于此前，在第一步初始化大顶堆后，所有父节点一定
    // 是大于孩子节点的，所以如果此处父节点比两个孩子节点大，再向下的孙子节点中也不会有更大的节点，所以就不需要再
    // 向下搜索
    if (largest != currentRoot) {
      swap(nums, largest, currentRoot);
      heapify(nums, largest, border);
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
