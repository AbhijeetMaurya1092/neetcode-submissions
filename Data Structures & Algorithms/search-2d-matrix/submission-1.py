class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        
        m = len(matrix)
        n = len(matrix[0])

        left = 0
        right = (m * n) - 1

        while left <= right:

            mid = left + (right - left) // 2

            row = mid // n
            col = mid % n

            current = matrix[row][col]

            if current == target:
                return True

            elif current < target:
                left = mid + 1

            else:
                right = mid - 1

        return False