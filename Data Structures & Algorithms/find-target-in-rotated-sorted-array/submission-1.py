class Solution:
    def search(self, nums: list[int], target: int) -> int:
        left = 0
        right = len(nums) - 1

        while left <= right:
            mid = left + (right - left) // 2

            # Target direct mid par mil gaya
            if nums[mid] == target:
                return mid

            # CASE 1: LEFT -> MID sorted hai
            if nums[left] <= nums[mid]:

                # Target LEFT -> MID range me hai?
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1

            # CASE 2: MID -> RIGHT sorted hai
            else:

                # Target MID -> RIGHT range me hai?
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1

        return -1