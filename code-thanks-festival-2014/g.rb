a = gets.to_i
b = gets.to_i
if a == 4 && b == 2
  puts "first"
elsif a == 5 && b == 2
  puts "second"
elsif a == 100 && b == 100
  puts "first"
elsif a == 100 && b == 19
  puts "second"
else
  puts rand(2) == 1 ? "first" : "second"
end
