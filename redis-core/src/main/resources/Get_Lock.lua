--[[
思路：
   1.用2个局部变量接受参数
   2.由于redis内置lua解析器，执行加锁命令
   3.如果加锁成功，则设置超时时间
   4.返回加锁命令的执行结果
]]
local key = KEYS[1]
local value = KEYS[2]

local rs1 = redis.call('SETNX',key,value)
if rs1 == true
then
   redis.call('SETEX', key,3600, value)
end

return rs1