A, B = gets.chomp.split(' ').map(&:to_i)

n = B - A
height = n * (n + 1) / 2
puts -(B - height)
