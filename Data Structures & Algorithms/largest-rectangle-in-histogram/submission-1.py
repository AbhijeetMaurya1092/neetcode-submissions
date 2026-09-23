class Solution:
    def largestRectangleArea(self, heights):
        stack = []
        maxArea = 0

        for i in range(len(heights) + 1):

            # End me imaginary 0
            currentHeight = 0 if i == len(heights) else heights[i]

            while stack and currentHeight < heights[stack[-1]]:

                height = heights[stack.pop()]

                if not stack:
                    width = i
                else:
                    width = i - stack[-1] - 1

                area = height * width
                maxArea = max(maxArea, area)

            if i < len(heights):
                stack.append(i)

        return maxArea