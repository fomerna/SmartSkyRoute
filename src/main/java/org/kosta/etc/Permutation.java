package org.kosta.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    private int n; // nPr의 n
    private int r; // nPr의 r
    private String[] res;

    // 초기화
    public Permutation(int n, int r) {
        this.n = n;
        this.r = r;
        res = new String[r];
    }

    public void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void perm(String[] arr, int depth, List<List<String>> list) {

        // depth가 0부터 시작했을 경우 depth == r에서 리턴
        if (depth == r) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < res.length; i++) {
                    temp.add(res[i]);
                }
                list.add(temp);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);     // 스왑
            res[depth] = arr[depth]; // 선택된 원소 저장
            perm(arr, depth + 1, list);     // 재귀호출
            swap(arr, depth, i);     // 복원
        }
        return;
    }
}
