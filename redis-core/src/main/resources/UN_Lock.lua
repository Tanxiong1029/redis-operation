--[[
思路：
   1.接受redis传来的参数
   2.判断是否是自己的锁，是则删掉
   3.返回结果值
]]
local key = KEYS[1]
local value = KEYS[2]

if redis.call('get',key) == value
then
    return redis.call('del',key)
else
    return false
end