k = gets.to_i

1.upto(k) do |i|
  puts "#{i%9}#{"9" * (i/9)}".to_i
end
