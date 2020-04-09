package overlapping.rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OverlappingRect {
    //Todo Need to Complete
    public static void main(String[] args) {
        String topRect, bottomRect;
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < testCaseCount; i++) {
            String firstRectPos = scanner.next();
            String secondRectPos = scanner.next();

            int first_y = Integer.valueOf(firstRectPos.split(",")[1]);
            int second_y = Integer.valueOf(secondRectPos.split(",")[1]);
            if (first_y < second_y) {
                bottomRect = firstRectPos;
                topRect = secondRectPos;
            } else {
                bottomRect = secondRectPos;
                topRect = firstRectPos;
            }
            resultList.add(computeArea(bottomRect, topRect));
        }

        System.out.println("The Result area is");
        resultList.forEach(System.out::println);
    }

    private static int computeArea(String bottomRect, String topRect) {
        int a1 = Integer.valueOf(bottomRect.split(",")[0]);
        int b1 = Integer.valueOf(bottomRect.split(",")[1]);
        int a2 = Integer.valueOf(bottomRect.split(",")[2]);
        int b2 = Integer.valueOf(bottomRect.split(",")[3]);

        int x1 = Integer.valueOf(topRect.split(",")[0]);
        int y1 = Integer.valueOf(topRect.split(",")[1]);
        int x2 = Integer.valueOf(topRect.split(",")[2]);
        int y2 = Integer.valueOf(topRect.split(",")[3]);

        boolean isVertiOverlapped = false, isHorizonOverlapped = false;
        int overlappedWidthX = 0, overlappedHeightY;
        int overlappedArea = 0, resultArea;

        int heightAB, widthAB, heightXY, widthXY;

        if ((x1 > a1) && (y1 > b1) && (x2 < a2) && (y2 < b2)) {

            overlappedArea = (x2 - x1) * (y2 - y1);
            //Check is subset or not
        } else {

            //Check if vertically overlapped or not
            if (b2 > y1) {
                isVertiOverlapped = true;

                //Check if horizontally overlapped or not
                if (a1 < x1) {
                    isHorizonOverlapped = a2 > x1;
                    overlappedWidthX = a2 - x1;
                } else {
                    isHorizonOverlapped = x2 > a1;
                    overlappedWidthX = x2 - a1;
                }
            }
            //If overlapped find Overlapped area
            if (isVertiOverlapped && isHorizonOverlapped) {
                overlappedHeightY = b2 - y1;
                overlappedArea = overlappedWidthX * overlappedHeightY;
            }
        }
        heightAB = b2 - b1;
        widthAB = a2 - a1;

        heightXY = y2 - y1;
        widthXY = x2 - x1;

        resultArea = (heightAB * widthAB) + (heightXY * widthXY) - overlappedArea;
        return resultArea;
    }
}
