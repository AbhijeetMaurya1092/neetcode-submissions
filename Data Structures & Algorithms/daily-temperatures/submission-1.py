class Solution:
    def dailyTemperatures(self, temperatures):
        n = len(temperatures)

        result = [0] * n
        stack = []

        for i in range(n):

            while stack and temperatures[i] > temperatures[stack[-1]]:
                oldIndex = stack.pop()
                result[oldIndex] = i - oldIndex

            stack.append(i)

        return result