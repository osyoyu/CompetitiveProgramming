# coding: UTF-8

gets
input = gets.split(" ")

sum = 0

input.each do |a|
  sum = sum * 2 + a.to_i
end

puts sum
