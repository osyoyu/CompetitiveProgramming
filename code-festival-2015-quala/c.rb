# coding: UTF-8

n, t = gets.chomp.split(" ")

used_time = 0
homeworks = []
n.to_i.times do
  a, b = gets.chomp.split(" ")
  homeworks.push(a.to_i - b.to_i)
  used_time += a.to_i
end
homeworks = homeworks.sort.reverse!

answer = 0
while used_time > t.to_i
  used_time -= homeworks[answer]
  answer += 1
  if answer == n.to_i && used_time > t.to_i
    puts "-1"
    exit
  end
end

puts answer
